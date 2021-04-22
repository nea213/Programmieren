import java.util.ArrayList;

public class Film extends Medium{
    private ArrayList<String> _regisseure;
    private int _laufzeit;

    @Override
    public String toString() {
        return "Film{" +
                "_regisseure=" + _regisseure +
                ", _laufzeit=" + _laufzeit +
                '}' + " -> " +
                super.toString();
    }

    public Film(
            int _medienNr,
            String _title,
            int _erscheinungsJahr,
            ArrayList<String> _regisseure,
            int _laufzeit
    ) {
        super(_medienNr, _title, _erscheinungsJahr);
        this._laufzeit = _laufzeit;
        this._regisseure = _regisseure;
    }
}
