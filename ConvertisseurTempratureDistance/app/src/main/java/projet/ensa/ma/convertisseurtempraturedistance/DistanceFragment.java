package projet.ensa.ma.convertisseurtempraturedistance;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DistanceFragment extends Fragment {

    RadioGroup Dist;
    RadioButton KmToMiles, MilesToKm;
    EditText DistInput;
    Button btnConvertDist;
    TextView DistResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_distance, container, false);

        Dist = view.findViewById(R.id.Dist);
        KmToMiles = view.findViewById(R.id.KmToMiles);
        MilesToKm = view.findViewById(R.id.MilesToKm);
        DistInput = view.findViewById(R.id.DistInput);
        btnConvertDist = view.findViewById(R.id.btnConvertDist);
        DistResult = view.findViewById(R.id.DistResult);

        btnConvertDist.setOnClickListener(v -> {
            String input = DistInput.getText().toString();
            if (TextUtils.isEmpty(input)) {
                Toast.makeText(getContext(), "Veuillez entrer une valeur", Toast.LENGTH_SHORT).show();
                return;
            }

            double val = Double.parseDouble(input);
            double result;

            if (KmToMiles.isChecked())

                result = val * 0.6214;

            else

                result = val / 0.6214;

            DistResult.setText("Résultat de la conversion : " + String.format("%.2f", result));
        });

        return view;
    }
}