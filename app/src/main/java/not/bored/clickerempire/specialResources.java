package not.bored.clickerempire;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class specialResources extends Fragment {

    public specialResources() {
        // Required empty public constructor
    }
    private specialResourcesListener resupdater;
    Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                while (!thread.isInterrupted()) {
                    Thread.sleep(100);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                TextView skins = getActivity().findViewById(R.id.num_skins);
                                skins.setText(resupdater.Skins());
                                TextView leather = getActivity().findViewById(R.id.num_leather);
                                leather.setText(resupdater.Leather());
                                TextView herbs = getActivity().findViewById(R.id.num_herbs);
                                herbs.setText(resupdater.Herbs());
                                TextView piety = getActivity().findViewById(R.id.num_piety);
                                piety.setText(resupdater.Piety());
                                TextView ore = getActivity().findViewById(R.id.num_ore);
                                ore.setText(resupdater.Ore());
                                TextView metal = getActivity().findViewById(R.id.num_metal);
                                metal.setText(resupdater.Metal());
                            }
                            catch (NullPointerException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (InterruptedException e) {
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_special_resources, container, false);
        TextView skins = view.findViewById(R.id.num_skins);
        skins.setText(resupdater.Skins());
        TextView herbs = view.findViewById(R.id.num_herbs);
        herbs.setText(resupdater.Herbs());
        TextView ore = view.findViewById(R.id.num_ore);
        ore.setText(resupdater.Ore());
        TextView leather = view.findViewById(R.id.num_leather);
        leather.setText(resupdater.Leather());
        TextView piety = view.findViewById(R.id.num_piety);
        piety.setText(resupdater.Piety());
        TextView metal = view.findViewById(R.id.num_metal);
        metal.setText(resupdater.Metal());
        thread.start();
        return view;

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof specialResourcesListener) {
            resupdater = (specialResourcesListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        thread.interrupt();
    }

    public interface specialResourcesListener {
        // TODO: Update argument type and name
        String Skins();
        String Leather();
        String Herbs();
        String Piety();
        String Ore();
        String Metal();
    }
}
