public class Tempo {
    private int h;
    private int m;
    private int s;

    // Taka construtores this pa evita repeti na hora de avalia variaveis
    public Tempo() {
        this(0, 0, 0);
    }

    public Tempo(int h) {
        this(h, 0, 0);
    }
    
    public Tempo(int h, int m) {
        this(h, m, 0);
    }

    public Tempo(int h, int m, int s) {
        // goci hm tem k controlar kes val ki e invalidos
        if (h >= 0 && h < 24) {
            this.h = h;
        } else {
            this.h = 0;
        }

        if (m >= 0 && m < 60) {
            this.m = m;
        } else {
            this.m = 0;
        }

        if (s >= 0 && s < 60) {
            this.s = s;
        } else {
            this.s = 0;
        }
    }

    // gets
    public int getHora() {
        return h;
    }

    public int getMinuto() {
        return m;
    }

    public int getSegundo() {
        return s;
    }

    // sets para controlar e aceitar valores validos (bool)
    public boolean setHora(int h) {
        if (h >= 0 && h < 24) {
            this.h = h;
            return true;
        } else {
            return false;
        }
    }

    public boolean setMinuto(int m) {
        if (m >= 0 && m < 60) {
            this.m = m;
            return true;
        } else {
            return false;
        }
    }

    public boolean setSegundo(int s) {
        if (s >= 0 && s < 60) {
            this.s = s;
            return true;
        } else {
            return false;
        }
    }

    // para spia se tene 2 digitos (metodo auxiliar privado)
    private String doisDigitos(int n) {
        if (n < 10) {
            return "0" + n;
        } else {
            return "" + n;
        }
    }

    // pa formato de hr pa bem tudo pegado
    public String paraHhmmss() {
        return doisDigitos(h) + doisDigitos(m) + doisDigitos(s);
    }

    // pa fuso horario
    public String paraAmPm() {
        int h12 = this.h % 12;
        if (h12 == 0) {
            h12 = 12;
        }

        String fuso;
        if (this.h < 12) {
            fuso = "AM";
        } else {
            fuso = "PM";
        }
        return doisDigitos(h12) + ":" + doisDigitos(this.m) + ":" + doisDigitos(this.s) + " " + fuso;
    }
// pa acrescentar 1 segundo
    public void acrescentarSegundo() {
        this.s++;
        if (this.s == 60) {
            this.s = 0;
            this.m++;
            if (this.m == 60) {
                this.m = 0;
                this.h++;
                if (this.h == 24) {
                    this.h = 0;
                }
            }
        }
    }
// pa acrescentar 1 minuto
    public int emSegundos() {
        return (this.h * 3600) + (this.m * 60) + (this.s);
    }

    public static Tempo deSegundos(int total) {
        int totalDia = total % 86400;
        if (totalDia < 0) {
            totalDia += 86400;
        }

        int h = totalDia / 3600;
        int m = (totalDia % 3600) / 60;
        int s = totalDia % 60;
        return new Tempo(h, m, s);
    }

    public Tempo diferenca(Tempo outro) {
        int total1 = this.emSegundos();
        int total2 = outro.emSegundos();
        int diferenca = total1 - total2;
        return deSegundos(diferenca);
    }

    public String toString() {
        return doisDigitos(this.h) + ":" + doisDigitos(this.m) + ":" + doisDigitos(this.s);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tempo outro = (Tempo) obj;
        return this.h == outro.h && this.m == outro.m && this.s == outro.s;
    }

    public int hashCode() {
        int resultado = h;
        resultado = 31 * resultado + m;
        resultado = 31 * resultado + s;
        return resultado;
    }
}
