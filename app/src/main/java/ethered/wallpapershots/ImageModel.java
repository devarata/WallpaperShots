package ethered.wallpapershots;

public class ImageModel {
    private String image_url;
    private String user_id;
    //Empty class for Firestore
    public ImageModel(){

    }
    public ImageModel(String imageURL, String userID) {
        image_url = imageURL;
        user_id = userID;
    }

    public String getimage_url() {
        return image_url;
    }

    public void setimage_url(String imageURL) {
        image_url = imageURL;
    }

    public String getuser_id() {
        return user_id;
    }

    public void setuser_id(String userID) {
        user_id = userID;
    }



}
