package tripservice.service;
// Original by Sandro Mancuso: https://www.youtube.com/watch?v=_NnElPO5BU0

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import tripservice.exception.UserNotLoggedInException;
import tripservice.model.Trip;
import tripservice.model.User;

public class TripService {
	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		User loggedUser = getLoggedUser();
		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		} 
		if (user.isFriendWith(loggedUser)) {
			return getTripsBy(user);
		} else {
			return new ArrayList<>();
		}
	}

	List<Trip> getTripsBy(User user) {
		return TripDAO.findTripsByUser(user);
	}

	 User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}
}
