package com.money.manager.ex.tutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.money.manager.ex.R;
import com.money.manager.ex.utils.RawFileUtils;

/**
 * Page displaying Dropbox functionality in tutorial.
 * Also, being the last page, it contains the OK button that closes the Tutorial.
 * A simple {@link Fragment} subclass.
 */
public class TutorialPageSyncFragment extends Fragment {

    public TutorialPageSyncFragment() {

    }

    public static TutorialPageSyncFragment newInstance(){
        TutorialPageSyncFragment fragment = new TutorialPageSyncFragment();
        Bundle bundle = new Bundle();

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tutorial_page_sync, container, false);

        WebView webView = (WebView)view.findViewById(R.id.webViewSync);

        // localization of the text.
        String content = RawFileUtils.getRawAsString(getActivity(), R.raw.tutorial_sync);
        // paragraphs
        content = content.replace("R.string.synchronization", getString(R.string.synchronization));
        content = content.replace("R.string.tutorial_sync_1", getString(R.string.tutorial_sync_1));
        // load page.
        webView.loadDataWithBaseURL("file:///android_asset/tutorial_images/", content, "text/html", "UTF-8", null);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
