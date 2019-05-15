package sandyakakom.gmail.pertemuan9;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mendeklarasikan variable button  dan imageView
        Button btnCamera = (Button) findViewById(R.id.btnCamera);
        imageView = findViewById(R.id.imageView);
        btnCamera.setOnClickListener(new View.OnClickListener() {

            // Mengirimkan intent ke sistem
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, 0);
            }
        });
    }
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data){
    super.onActivityResult(requestCode, resultCode, data);
   // Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
    //imageView.setImageBitmap(imageBitmap);
    // data ditulis pada kamera dan tidak dikembalikan ke intent data.
    if (requestCode == 0) {
        if (resultCode == RESULT_OK) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
}}
