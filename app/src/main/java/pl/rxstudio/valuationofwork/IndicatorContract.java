package pl.rxstudio.valuationofwork;

import android.provider.BaseColumns;

public final class IndicatorContract {

    private IndicatorContract() {}

    public static class IndicatorZTable implements BaseColumns {
        public static final String TABLE_NAME = "indicatorZCategories";
        public static final String COLUMN_FUNCTIONAL_GROUPS = "functionalGroups";
        public static final String COLUMN_OBJECTS = "objects";
        public static final String COLUMN_CATEGORY = "category";
    }

    static String[] wybKatTyp = {"dalne",
            "Bdra",
            "Adminisda i łączność",
            "Stradlicja, więzienia",
            "Handdsługi",
            "Ośwda",
            "Ndka",
            "Zdda społeczna",
            "Kudra",
            "Obiektydtu religijnego",
            "Sport i rekreacja",
            "Hotele i turystyka",
            "Rolnicze",
            "Komunikacja",
            "Przemysł i magazyny",
            "Militarne i obrony cywilnej",
            "Inne"
    };

    static String[] wybKatTyp2 = {"Mieszkalne",
            "Biura",
            "Administracja i łączność",
            "Straż, policja, więzienia",
            "Handel i usługi",
            "Oświata",
            "Nauka",
            "Zdrowie i opieka społeczna",
            "Kultura",
            "Obiekty kultu religijnego",
            "Sport i rekreacja",
            "Hotele i turystyka",
            "Rolnicze",
            "Komunikacja",
            "Przemysł i magazyny",
            "Militarne i obrony cywilnej",
            "Inne"
    };

}
