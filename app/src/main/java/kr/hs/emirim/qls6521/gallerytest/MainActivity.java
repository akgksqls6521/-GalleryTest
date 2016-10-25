package kr.hs.emirim.qls6521.gallerytest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Gallery gallery;
    ImageView imgMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery=(Gallery)findViewById(R.id.gallery_1);
        imgMain=(ImageView)findViewById(R.id.imgv_main);
        MyGalleryAdapter adapter=new MyGalleryAdapter(this);
        gallery.setAdapter(adapter);
    }

    public class MyGalleryAdapter extends BaseAdapter{
        Context context;
        int[] lineIDs={R.drawable.brown,R.drawable.coni,R.drawable.moon, R.drawable.boss,
                R.drawable.sally,R.drawable.lenerd,R.drawable.jessica,
                R.drawable.line,R.drawable.edward,R.drawable.james};


        MyGalleryAdapter(Context context){
            this.context=context;//context 는 참조변수로 받은 context값이다
        }

        @Override
        public int getCount() {
            return lineIDs.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imgV=new ImageView(context.getApplicationContext());//위에 필드를 저장해놨기때문에 .. 이 갤러리가 사용되는 문맥이 필요한데? 이건 마이갤러리어댑터 만들때 저장이 되었구나!
            imgV.setLayoutParams(new Gallery.LayoutParams(100,150));//px단위임
            imgV.setScaleType(ImageView.ScaleType.FIT_CENTER);//가장자리가 잘릴수도있음
            imgV.setPadding(5,5,5,5);
            imgV.setImageResource(lineIDs[position]);
            final int pos=position;
            imgV.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    imgMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imgMain.setImageResource(lineIDs[pos]);//이미지리소스설정
                    return false;
                }
            });
            return imgV;
        }
    }
}
