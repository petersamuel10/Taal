package com.vavisa.taal.data.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("user_id")
    private String userId;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("user_mobile")
    private String userMobile;
    @SerializedName("user_email")
    private String userEmail;
    @SerializedName("user_img")
    private String userImg;
    @SerializedName("user_cover_img")
    private String userCoverImg;
    @SerializedName("user_dob")
    private String userDob;
    @SerializedName("user_gender")
    private String userGender;
    @SerializedName("user_bio")
    private String userBio;
    @SerializedName("user_interest")
    private String userInterest;
    @SerializedName("user_loc")
    private String userLoc;
    @SerializedName("user_status")
    private String userStatus;
    @SerializedName("admin_status")
    private String adminStatus;
    @SerializedName("user_device_type")
    private String userDeviceType;
    @SerializedName("user_device_id")
    private String userDeviceId;
    @SerializedName("user_device_token")
    private String userDeviceToken;
    @SerializedName("v_code")
    private String vCode;
    @SerializedName("m_code")
    private String mCode;
    @SerializedName("user_token")
    private String userToken;
    @SerializedName("account_mode")
    private String accountMode;
    @SerializedName("notification_mode")
    private String notificationMode;
    @SerializedName("language_mode")
    private String languageMode;
    @SerializedName("pass_code")
    private String passCode;
    @SerializedName("report_post")
    private String reportPost;
    @SerializedName("created_on")
    private String createdOn;
    @SerializedName("updated_on")
    private String updatedOn;
    @SerializedName("token_id")
    private String tokenId;


    @SerializedName("nooffollowers")
    private String noOfFollowers;
    @SerializedName("noofeventscreated")
    private String noOfEventsCreated;

    private String errorMessage;

    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImg() {
        return userImg;
    }
    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserCoverImg() {
        return userCoverImg;
    }
    public void setUserCoverImg(String userCoverImg) {
        this.userCoverImg = userCoverImg;
    }

    public String getUserDob() {
        return userDob;
    }
    public void setUserDob(String userDob) {
        this.userDob = userDob;
    }

    public String getUserGender() {
        return userGender;
    }
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserBio() {
        return userBio;
    }
    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public String getUserInterest() {
        return userInterest;
    }
    public void setUserInterest(String userInterest) {
        this.userInterest = userInterest;
    }

    public String getUserLoc() {
        return userLoc;
    }
    public void setUserLoc(String userLoc) {
        this.userLoc = userLoc;
    }

    public String getUserStatus() {
        return userStatus;
    }
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getAdminStatus() {
        return adminStatus;
    }
    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    public String getUserDeviceType() {
        return userDeviceType;
    }
    public void setUserDeviceType(String userDeviceType) {
        this.userDeviceType = userDeviceType;
    }

    public String getUserDeviceId() {
        return userDeviceId;
    }
    public void setUserDeviceId(String userDeviceId) {
        this.userDeviceId = userDeviceId;
    }

    public String getUserDeviceToken() {
        return userDeviceToken;
    }
    public void setUserDeviceToken(String userDeviceToken) {
        this.userDeviceToken = userDeviceToken;
    }

    public String getvCode() {
        return vCode;
    }
    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

    public String getmCode() {
        return mCode;
    }
    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getUserToken() {
        return userToken;
    }
    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getAccountMode() {
        return accountMode;
    }
    public void setAccountMode(String accountMode) {
        this.accountMode = accountMode;
    }

    public String getNotificationMode() {
        return notificationMode;
    }
    public void setNotificationMode(String notificationMode) {
        this.notificationMode = notificationMode;
    }

    public String getLanguageMode() {
        return languageMode;
    }
    public void setLanguageMode(String languageMode) {
        this.languageMode = languageMode;
    }

    public String getPassCode() {
        return passCode;
    }
    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public String getReportPost() {
        return reportPost;
    }
    public void setReportPost(String reportPost) {
        this.reportPost = reportPost;
    }

    public String getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }
    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getTokenId() {
        return tokenId;
    }
    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getNoOfFollowers() {
        return noOfFollowers;
    }
    public void setNoOfFollowers(String noOfFollowers) {
        this.noOfFollowers = noOfFollowers;
    }

    public String getNoOfEventsCreated() {
        return noOfEventsCreated;
    }
    public void setNoOfEventsCreated(String noOfEventsCreated) {
        this.noOfEventsCreated = noOfEventsCreated;
    }
}
