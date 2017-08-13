package thesis.eng.reviewer.helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by jamesdeperio on 8/5/2017.
 */

public class FragmentChange {
    public static void load(int layoutID, FragmentManager fragmentManager, Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(layoutID, fragment, fragment.getClass().getSimpleName())
                .disallowAddToBackStack()
                .commit();
    }
    public static void loadWithBackStack(int layoutID, FragmentManager fragmentManager, Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(layoutID, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }
}
