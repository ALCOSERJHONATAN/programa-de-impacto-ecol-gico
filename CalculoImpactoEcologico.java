import java.util.ArrayList;

// Definición de la interfaz para calcular el impacto ecológico
interface ImpactoEcologico {
    double obtenerImpactoEcologico();
}

// Clase para representar un edificio y calcular su impacto ecológico
class Edificio implements ImpactoEcologico {
    private String nombre;
    private int consumoEnergia; // en kilovatios-hora por año
    private static final double FACTOR_EDIFICIO = 0.2; // Factor de impacto ecológico específico para edificios

    public Edificio(String nombre, int consumoEnergia) {
        this.nombre = nombre;
        this.consumoEnergia = consumoEnergia;
    }

    @Override
    public double obtenerImpactoEcologico() {
        return consumoEnergia * FACTOR_EDIFICIO;
    }

    public String getNombre() {
        return nombre;
    }
}

// Clase para representar un auto y calcular su impacto ecológico
class Auto implements ImpactoEcologico {
    private String marca;
    private double emisiones; // en toneladas métricas de CO2 por año
    private static final double FACTOR_AUTO = 2.0; // Factor de impacto ecológico específico para autos

    public Auto(String marca, double emisiones) {
        this.marca = marca;
        this.emisiones = emisiones;
    }

    @Override
    public double obtenerImpactoEcologico() {
        return emisiones * FACTOR_AUTO;
    }

    public String getMarca() {
        return marca;
    }
}

// Clase para representar una bicicleta y calcular su impacto ecológico
class Bicicleta implements ImpactoEcologico {
    private String modelo;
    private boolean electrica;
    private static final double FACTOR_BICICLETA_ELECTRICA = 0.1;
    private static final double FACTOR_BICICLETA_COMUN = 0.05;

    public Bicicleta(String modelo, boolean electrica) {
        this.modelo = modelo;
        this.electrica = electrica;
    }

    @Override
    public double obtenerImpactoEcologico() {
        return electrica ? FACTOR_BICICLETA_ELECTRICA : FACTOR_BICICLETA_COMUN;
    }

    public String getModelo() {
        return modelo;
    }
}

// Clase principal que crea objetos, los almacena en un ArrayList y calcula su impacto ecológico
public class CalculoImpactoEcologico {
    public static void main(String[] args) {
        ArrayList<ImpactoEcologico> objetos = new ArrayList<>();

        Edificio edificio = new Edificio("Edificio A", 500);
        Auto auto = new Auto("Toyota", 120);
        Bicicleta bicicleta = new Bicicleta("Modelo X", true);

        objetos.add(edificio);
        objetos.add(auto);
        objetos.add(bicicleta);

        for (ImpactoEcologico objeto : objetos) {
            System.out.println("Identificación: " + getIdentificacion(objeto));
            System.out.println("Impacto Ecológico: " + objeto.obtenerImpactoEcologico());
            System.out.println("------------------------------");
        }
    }

    private static String getIdentificacion(ImpactoEcologico objeto) {
        if (objeto instanceof Edificio) {
            return "Edificio: " + ((Edificio) objeto).getNombre();
        } else if (objeto instanceof Auto) {
            return "Auto: " + ((Auto) objeto).getMarca();
        } else if (objeto instanceof Bicicleta) {
            return "Bicicleta: " + ((Bicicleta) objeto).getModelo();
        } else {
            return "Identificación no disponible";
        }
    }
}
