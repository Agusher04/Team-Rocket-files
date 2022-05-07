package org.team_rocket_unc.electronica_digital_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.CalculatorMenuFragment;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.ColorCodeResistorsToolFragment;
import org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.LogicFunctionsMenuFragment;
import org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh.KarnaughToolFragment;
import org.team_rocket_unc.electronica_digital_app.units.unit_5_datasheets.DatasheetsToolFragment;

public class MainFragment extends Fragment {

    private Button calculators;
    private Button colorCodeResistors;
    private Button logicFunctions;
    private Button karnaugh;
    private Button datasheets;

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.layout_start,container,false);

        setTool(calculators, R.id.buttonCalculators, new CalculatorMenuFragment());
        setTool(colorCodeResistors, R.id.buttonColorCodeResistors, new InstructionsFragment("Código de colores de resistencias",
                "En esta herramienta usted podrá ingresar las bandas de colores de una resistencia para conocer su valoro bien ingresar un valor para conocer las bandas correctas",
                new ColorCodeResistorsToolFragment()));
        setTool(logicFunctions, R.id.buttonLogicFunctions, new LogicFunctionsMenuFragment());
        setTool(karnaugh, R.id.buttonKarnaugh, new InstructionsFragment("Mapas de Karnaugh",
                "Esta herramienta le permitirá reducir funciones lógicas al igual que lo haría\n" +
                        "con un mapa de Karnaugh. Para poder implementarlo computacionalmente se emplearán los algorítmos de Quine-McCliskey y Petrick.\n" +
                        "El usuario podrá optar por resolver su simplificación por cualquiera de estos algorítmos",
                new KarnaughToolFragment()));
        setTool(datasheets, R.id.buttonDatasheets, new InstructionsFragment("Datasheets",
                "En esta sección usted encontrará acceso a las DataSheet de los chips más utilizados en la materia Electrónica digital 1",
                new DatasheetsToolFragment()));

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