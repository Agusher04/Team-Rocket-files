package teamrocket.org.electronicadigital.H3LogicFunctions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import teamrocket.org.electronicadigital.H1Calculators.conversionTool.ConversionToolFragment;
import teamrocket.org.electronicadigital.H1Calculators.ledCircuitTool.LedCircuitToolFragment;
import teamrocket.org.electronicadigital.H1Calculators.ohmTool.OhmToolFragment;
import teamrocket.org.electronicadigital.H3LogicFunctions.logicGates.LogicGatesToolFragment;
import teamrocket.org.electronicadigital.H3LogicFunctions.truthTables.TruthTablesToolFragment;
import teamrocket.org.electronicadigital.InstructionsFragment;
import teamrocket.org.electronicadigital.R;

public class LogicFunctionsMenuFragment extends Fragment {

    View view;
    Button truthTableButton;
    Button logicGatesButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_h3_logic_functions_menu,container,false);

        setTool(truthTableButton, R.id.buttonTruthTable, new InstructionsFragment("Tabla de verdad",
                "Instrucciones de la tabla de verdad",
                new TruthTablesToolFragment()));
        setTool(logicGatesButton, R.id.buttonGateConection, new InstructionsFragment("Compuertas lógicas",
                "Instrucciones para las compuertas lógicas",
                new LogicGatesToolFragment()));
        return view;
    }

    private void setTool(Button targetToolButton, int targetToolButtonId, Fragment targetToolFragment) {
        targetToolButton = view.findViewById(targetToolButtonId);
        targetToolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, targetToolFragment).commit();
            }
        });
    }
}
