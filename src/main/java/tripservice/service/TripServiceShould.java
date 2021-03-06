package tripservice.service;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import tripservice.exception.UserNotLoggedInException;
import tripservice.model.Trip;
import tripservice.model.User;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceShould {
		
	
	private User targetUser = new User();
	private User loggedUser = new User();
	private List<Trip> targetTrips = new ArrayList<>();
	
	@Spy
	private TripService tripService = new TripService();
	
	@Before
	public void setupSpy() {
		doAnswer($ -> loggedUser).when(tripService).getLoggedUser();
//		doReturn(loggedUser).when(tripService).getLoggedUser(); // does not work
		doReturn(targetTrips).when(tripService).getTripsBy(targetUser);
	}

	@Test(expected = UserNotLoggedInException.class)
	public void throwWhenNoLoggedUser() throws UserNotLoggedInException {
		loggedUser = null;
		tripService.getTripsByUser(targetUser);
	}
	
	@Test
	public void returnsEmptyListWhenLoggedUserHasNoFriends() throws UserNotLoggedInException {
		List<Trip> trips = tripService.getTripsByUser(targetUser);
		assertTrue(trips.isEmpty());
//        assertEquals(emptyList(), trips);
	}
	
	@Test
	public void returnsEmptyListWhenTargetUserIsNotFriendWithLoggedUser() throws UserNotLoggedInException {
		targetUser.addFriend(new User());
		List<Trip> trips = tripService.getTripsByUser(targetUser);
		assertTrue(trips.isEmpty());
	}
	
    @Test
    public void returnsTargetUserTripsWhenTheyAreFriends() throws UserNotLoggedInException {
        targetUser.addFriend(loggedUser);
        Trip trip = new Trip();
		targetTrips.add(trip);
        List<Trip> trips = tripService.getTripsByUser(targetUser);
        assertEquals(singletonList(trip), trips);
    }
    
//    public static void main(String[] args) {
//		TripService spy = Mockito.spy(new TripService());
////		when(spy.getLoggedUser()).thenReturn(null);
//		doReturn(null).when(spy).getLoggedUser();
//		User u = spy.getLoggedUser();
//		System.out.println(u);
//		
//		
//	}
//    
    
}
