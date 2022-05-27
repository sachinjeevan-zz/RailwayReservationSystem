package com.railways.users;

public class RailwayUserEntity 
{
		private Integer railwayUserId;
		private String  railwayUserName;
		private String 	railwayUserMailId;
		private String 	railwayUserPassword;
		private String  railwayUserGender;
		private Byte 	railwayUserAge;
		private Long 	railwayUserMobileNumber;
		private static String railwayUserRole;
		
		public Integer getRailwayUserId() {
			return railwayUserId;
		}
		
		public void setRailwayUserId(Integer passengerId) {
			this.railwayUserId = passengerId;
		}
		
		public String getRailwayUserName() {
			return railwayUserName;
		}
		
		public void setRailwayUserName(String passengerName) {
			this.railwayUserName = passengerName;
		}
		
		public String getRailwayUserMailId() {
			return railwayUserMailId;
		}
		
		public void setRailwayUserMailId(String passengerMailId) {
			this.railwayUserMailId = passengerMailId;
		}
		
		public String getRailwayUserPassword() {
			return railwayUserPassword;
		}
		
		public void setRailwayUserPassword(String passengerPassword) {
			this.railwayUserPassword = passengerPassword;
		}
		
		public String getRailwayUserGender() {
			return railwayUserGender;
		}
		
		public void setRailwayUserGender(String passengerGender) {
			this.railwayUserGender = passengerGender;
		}
		
		public Byte getRailwayUserAge() {
			return railwayUserAge;
		}
		
		public void setRailwayUserAge(Byte passengerAge) {
			this.railwayUserAge = passengerAge;
		}
		
		public Long getRailwayUserMobileNumber() {
			return railwayUserMobileNumber;
		}
		
		public void setRailwayUserMobileNumber(Long passengerMobileNumber) {
			this.railwayUserMobileNumber = passengerMobileNumber;
		}

		public static String getRailwayUserRole() {
			return railwayUserRole;
		}

		public static void setRailwayUserRole(String railwayUserRole) {
			RailwayUserEntity.railwayUserRole = railwayUserRole;
		}

}
