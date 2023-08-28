package ethered.wallpapershots;
import android.app.WallpaperManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Created by Mitul Champaneri on 3/3/2018.
 */

public class Fullimage2 extends AppCompatActivity {
    private CropImageView cropImageView;
    private Button button;
    private ImageView image;
    String Url;
    Bitmap bmap;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage2);
        Context context;
        context = getApplicationContext();
        cropImageView = (CropImageView)findViewById(R.id.cropImageView);
        button = (Button)findViewById(R.id.button);
        image = (ImageView) findViewById(R.id.fullimg);
        RequestOptions options = new RequestOptions();
        Bundle extras = getIntent().getExtras();
        Url = extras.getString("url");
        Log.d("Fullimage",Url);
        RequestOptions requestOptions  = new RequestOptions();
        GlideApp
                .with(context)
                .load(Url)
                .apply(requestOptions)
                .into(image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            getbitmap();
            setwallpaper();
            }
        });
    }
    private void getbitmap(){
        image.buildDrawingCache();
        bmap= image.getDrawingCache();
       // cifbitmap = createImageFromBitmap(bmap);
    //    cropImageView.setImageBitmap(bmap);
     /*   Intent i =new Intent(this,flowactivity.class);
        i.putExtra("urlnextactivity", Url);
       // i.putExtra("bitmap",bmap);
        startActivity(i);
 */
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
    private void setwallpaper() {
        try {
            WallpaperManager mywallapapermanager = WallpaperManager.getInstance(this);
            mywallapapermanager.setBitmap(bmap);
            Toast.makeText(getApplicationContext(),"Wallpaper SET",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // subscribe to async event using cropImageView.setOnCropImageCompleteListener(listener)
/*New Version Comment*//*CcropImageView.setOnCropImageCompleteListener(new CropImageView.OnCropImageCompleteListener() {

          @Override
        public void onCropImageComplete(CropImageView view,CropImageView.CropResult result) {

        }
    });
    Bitmap cropped = cropImageView.getCroppedImage();


    public String createImageFromBitmap(Bitmap bitmap) {
        String fileName = "myImage";//no .png or .jpg needed
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            FileOutputStream fo = openFileOutput(fileName, Context.MODE_PRIVATE);
            fo.write(bytes.toByteArray());
            // remember close file output
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
            fileName = null;
        }
        return fileName;
    }*/
}
