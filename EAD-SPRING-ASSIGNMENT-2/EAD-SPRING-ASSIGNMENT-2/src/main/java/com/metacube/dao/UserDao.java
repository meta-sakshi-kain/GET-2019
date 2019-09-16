package com.metacube.dao;

import java.util.List;

import com.metacube.dto.EmployeeDetails;


import com.metacube.dto.Friend;
import com.metacube.dto.FriendProfile;
import com.metacube.model.pojo.User;

public interface UserDao {

	public boolean add(User user);

	public int getUserRegId(String email);

	public boolean userExists(String email);

	public String getPassword(String email);

	public EmployeeDetails getEmpDetails(Integer regId);

	public List<Friend> getFriendList(Integer empRegId,
			String empOrganization);

	public FriendProfile getFriendProfile(Integer regId);

	public boolean updateDetail(EmployeeDetails emp);

	public boolean userAddedVehicle(int userRegId);

}
