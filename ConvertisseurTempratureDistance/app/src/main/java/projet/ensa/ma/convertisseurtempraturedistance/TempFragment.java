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

public class TempFragment extends Fragment {

    RadioGroup TempChoice;
    RadioButton CtoF, FtoC;
    EditText TempInput;
    Button bouttonConvertTemp;
    TextView TempResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_temp, container, false);

        TempChoice = view.findViewById(R.id.TempChoice);
        CtoF = view.findViewById(R.id.CtoF);
        FtoC = view.findViewById(R.id.FtoC);
        TempInput = view.findViewById(R.id.TempInput);
        bouttonConvertTemp = view.findViewById(R.id.bouttonConvertTemp);
        TempResult = view.findViewById(R.id.TempResult);

        bouttonConvertTemp.setOnClickListener(v -> {
            String input = TempInput.getText().toString();
            if (TextUtils.isEmpty(input)) {
                Toast.makeText(getContext(), "Veuillez entrer une valeur", Toast.LENGTH_SHORT).show();
                return;
            }

            double val = Double.parseDouble(input);
            double result;

            if (CtoF.isChecked())
                result = (1.8 * val) + 32;
            else
                result = (val - 32) / 1.8;

            TempResult.setText("Résultat : " + String.format("%.2f", result));
        });

        return view;
    }
}
