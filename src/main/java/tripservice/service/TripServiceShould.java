package tripservice.service;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import tripservice.exception.UserNotLoggedInException;
import tripservice.model.Trip;
import tripservice.model.User;

public class TripServiceShould {
	private User targetUser = new User();
	private User loggedUser = new User();
	private List<Trip> targetTrips = new ArrayList<>();
	
	private class TripServiceTestable extends TripService {
		@Override
		User getLoggedUser() {
			return loggedUser;
		}	
		List<Trip> getTripsBy(User user) {
			return targetTrips;
		}
	}
	private TripService tripService = new TripServiceTestable();

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
    
    
}
