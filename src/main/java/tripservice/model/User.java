package tripservice.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private List<User> friends = new ArrayList<>();
	
	public List<User> getFriends() {
		return friends;
	}
	
	public void addFriend(User friend) {
		this.friends.add(friend);
		friend.friends.add(this);
	}

	public boolean isFriendWith(User anotherUser) {
		return friends.contains(anotherUser);
		
	//		return user.getFriends().stream().anyMatch(u -> u.equals(loggedUser));
		
	//		return user.getFriends().stream().anyMatch(loggedUser::equals);
		
	//		for (User friend : user.getFriends()) {
	//			if (friend.equals(loggedUser)) {
	//				return true;
	//			}
	//		}
	//		return false;
		
	}

}
