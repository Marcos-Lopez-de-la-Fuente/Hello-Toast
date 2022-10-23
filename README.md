# Hello-Toast

Project in Android Studio to make a counter and display it on the screen

<details>

**<summary>Application Images</summary>**

<img src="resForReadme/gifApp.gif">

</details>

## Functioning general (User view)

-   You will see a counter starting from 0.

-   You can increase the counter by +1 by pressing a button.

-   The counter value can be displayed using a `Toast`.

## Functioning technical

The program will be divided into the following sections:

-   ### **Java files** (Application Backend):

    -   **`MainActivity.java`**
        -   Main activity of the program, users will be able to see the counter, add +1 to the counter and display the value of the counter through a `Toast`. If the device is rotated horizontally, the counter value will be saved.

-   ### **XML files** (Application Frontend):

    -   **`activity_main.xml`** (Vertical and horizontal)

        -   Inside a `LinearLayout` tag, we will insert 2 `Button` tags and 1 `TextView` tag, to display the counter value, add +1 to the counter, and display the counter value via a `Toast`.

## **Code**

<details>

**<summary>MainActivity.java</summary>**

```java
package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonToast;
    private Button buttonCount;
    private TextView showCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.buttonToast = findViewById(R.id.button_toast);
        this.buttonCount = findViewById(R.id.button_count);
        this.showCount = findViewById(R.id.show_count);


        if (savedInstanceState != null) {
            this.showCount.setText(savedInstanceState.getString("numberCount"));
        }


        this.buttonCount.setOnClickListener(view ->
                this.sumCount()
        );

        this.buttonToast.setOnClickListener(view ->
                this.showToastCount()
        );
    }

    public void sumCount() {
        int sum = Integer.parseInt((String) this.showCount.getText()) + 1;
        this.showCount.setText(String.valueOf(sum));

    }


    public void showToastCount() {
        Toast.makeText(this, showCount.getText(), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("numberCount", (String) this.showCount.getText());

    }
}
```

</details>

<details>

**<summary>activity_main.xml (vertical)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="20sp"
    android:gravity="center"
    android:orientation="vertical">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="60sp"
        android:text="Toast" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="500sp"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="150sp"
        android:textStyle="bold" />


    <Button
        android:id="@+id/button_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="60sp"
        android:text="Count" />


</LinearLayout>
```

</details>

<details>

**<summary>activity_main.xml (land)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="20sp"
    android:gravity="center"
    android:orientation="vertical">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="60sp"
        android:text="Toast" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="150sp"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="100sp"
        android:textStyle="bold" />


    <Button
        android:id="@+id/button_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="60sp"
        android:text="Count" />


</LinearLayout>
```

</details>
