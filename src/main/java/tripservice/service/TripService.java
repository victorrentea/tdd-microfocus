package tripservice.service;
// Original by Sandro Mancuso: https://www.youtube.com/watch?v=_NnElPO5BU0

import java.util.ArrayList;
import java.util.List;

import tripservice.exception.UserNotLoggedInException;
import tripservice.model.Trip;
import tripservice.model.User;

public class TripService {
	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<>();
		User loggedUser = getLoggedUser();
		boolean isFriend = false;
		if (loggedUser !=null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = getTripsBy(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}

	 List<Trip> getTripsBy(User user) {
		return TripDAO.findTripsByUser(user);
	}

	 User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}
}
