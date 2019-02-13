package victor.mocks.telemetry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import victor.mocks.telemetry.TelemetryClient.ClientConfiguration.AckMode;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TelemetryDiagnosticControlsTest {

    @Mock
    private TelemetryClient client;
    @InjectMocks
    private TelemetryDiagnosticControls controls;

    @Before
    public void setupMocks() {
        when(client.getOnlineStatus()).thenReturn(true);
    }

    @Test(expected = IllegalStateException.class)
    public void throwsWhenOnlineStatusFalse() throws Exception {

        when(client.getOnlineStatus()).thenReturn(false);
        controls.checkTransmission();
//        verify(client).initialize();
//        verify(client).getOnlineStatus(); // Chiar merita ?!!!
    }

    @Test
    public void callsDisconnect() throws Exception {

        controls.checkTransmission();
        verify(client).disconnect();
//        verifyNoMoreInteractions(client);
    }

    @Test
    public void callsSend() throws Exception {
        controls.checkTransmission();
        verify(client, Mockito.times(1)).send(TelemetryClient.DIAGNOSTIC_MESSAGE);
    }

    @Test
    public void callsReceive() throws Exception {
        when(client.receive()).thenReturn("tataie");
        controls.checkTransmission();
        assertEquals("tataie", controls.getDiagnosticInfo());
    }

    @Test
    public void callsConfigureClient() throws Exception {
        controls.checkTransmission();
        ArgumentCaptor<TelemetryClient.ClientConfiguration> captor = ArgumentCaptor.forClass(TelemetryClient.ClientConfiguration.class);

        verify(client).configure(captor.capture());
        TelemetryClient.ClientConfiguration configuration = captor.getValue();
        assertEquals(AckMode.NORMAL,configuration.getAckMode());
    }

    @Test
    public void createConfig(){
    TelemetryClient.ClientConfiguration config = controls.createConfig();
    assertEquals(AckMode.NORMAL,config.getAckMode());
}
}

