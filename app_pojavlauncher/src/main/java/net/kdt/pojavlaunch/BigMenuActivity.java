package net.kdt.pojavlaunch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class BigMenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_menu);

        // Launch game -> existing Pojav launcher screen (version select + Play)
        findViewById(R.id.btn_launch).setOnClickListener(v ->
                startActivity(new Intent(this, TestStorageActivity.class)));

        // Step 4: built-in file manager
        findViewById(R.id.btn_files).setOnClickListener(v -> soon("Open files"));

        // Step 5: controls editor shortcut
        findViewById(R.id.btn_controls).setOnClickListener(v -> soon("Add controls"));

        // Step 3: Modrinth browser
        findViewById(R.id.btn_mods).setOnClickListener(v -> soon("Install mod"));

        // Step 6: settings (FPS, renderer, RAM)
        findViewById(R.id.btn_settings).setOnClickListener(v -> soon("Settings"));

        findViewById(R.id.btn_credits).setOnClickListener(v -> showCredits());
    }

    private void soon(String name) {
        Toast.makeText(this, name + " - coming in next step", Toast.LENGTH_SHORT).show();
    }

    private void showCredits() {
        new android.app.AlertDialog.Builder(this)
                .setTitle("Credits")
                .setMessage("BIG LANCHER\n\nBased on PojavLauncher (LGPL-3.0)\nMods from Modrinth\nRenderer: MobileGlues (LGPL-2.1)\n\nMade by you.")
                .setPositiveButton("Source", (d, w) -> startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/PojavLauncherTeam/PojavLauncher"))))
                .setNegativeButton("Close", null)
                .show();
    }
}
