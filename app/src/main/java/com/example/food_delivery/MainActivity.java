package com.example.food_delivery;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.food_delivery.model.DataController;
import com.example.food_delivery.model.MenuItem;
import com.example.food_delivery.model.ResaurantInterface;
import com.example.food_delivery.model.Restrurent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ResaurantInterface {
    private static final String TAG = "MainActivity";
    ResaurantInterface resaurantInterface;
    DataController controller;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        resaurantInterface=this;
        controller=DataController.getInstance();
        //controller.
        controller.setResaurantInterface(resaurantInterface);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        navController= Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
       SendDataToFirestore();

    }

    private void getDataFromFirestore() {
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("Resturants")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for(DocumentSnapshot documentSnapshot:task.getResult()){
                    Restrurent restrurent=documentSnapshot.toObject(Restrurent.class);
                    Log.e(TAG,"onComplete: "+restrurent.getRestrurentName());
                }


            }
        });
    }

    private void SendDataToFirestore() {
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        CollectionReference reference=db.collection("Resturants");
        Restrurent restrurent=new Restrurent();
        restrurent.setRestrurentName("Diponkar Restaurant");
        restrurent.setRestrurentDescription("best restaurant");
        restrurent.setRestrurentLocation("dhaka,savar");
        restrurent.setRestrurentImageUrl("https://static.toiimg.com/photo/72023714.cms");
        List<MenuItem> menuItems=new ArrayList<>();
        for(int i=0;i<15;i++){
            menuItems.add(new MenuItem("mutton kacci","khub e test",350));
        }
        restrurent.setRestaurantMenuList(menuItems);

        reference.add(restrurent).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this,"Restaurent uploaded",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onRestaurantClick(Restrurent restrurent) {
       // action_navigation_home_to_navigation_menu
        controller.setCurrentMenuItemList(restrurent.getRestaurantMenuList());
        navController.navigate(R.id.action_navigation_home_to_navigation_menu);

    }
}