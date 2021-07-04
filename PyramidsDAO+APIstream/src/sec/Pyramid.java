package sec;

public class Pyramid {
    private String pharoa;
    private String incientName;
    private String modernName;
    private String site;
    private String type;
    private String lepsius;
    private String material;

    private String dynasty;
    public String base1;
    private String base2;
    private String height;
    private String slope;
    private String volume;
    private String latitude;
    private String longitude;


    public String getPharoa() {
        return pharoa;
    }

    public String getIncientName() {
        return incientName;
    }

    public String getModernName() {
        return modernName;
    }

    public String getSite() {
        return site;
    }

    public String getType() {
        return type;
    }

    public String getLepsius() {
        return lepsius;
    }

    public String getMaterial() {
        return material;
    }

    public int getDynasty() {
        return Integer.parseInt(dynasty);
    }

    public Double getBase1() {
        return Double.valueOf(base1);
    }

    public float getBase2() {
        return Float.parseFloat(base2);
    }

    public float getHeight() {
        return Float.parseFloat(height);
    }

    public float getSlope() {
        return Float.parseFloat(slope);
    }

    public float getVolume(){
        return Float.parseFloat(volume);
    }

    public float getLatitude() {
        return Float.parseFloat(latitude);
    }

    public float getLongitude() {
        return Float.parseFloat(longitude);
    }
int i=1;
    public Pyramid(String[] a){
    for(int i=0;i<a.length;i++){if (a[i]==""||a[i]==null){a[i]="0";}}
        this.pharoa=a[0];
        this.incientName=a[1];
        this.modernName=a[2];
        this.site=a[4];
        this.type=a[12];
        this.lepsius=a[13];
        this.material=a[14];

        this.dynasty=a[3];
        this.base1=a[5];
        this.base2=a[6];
        this.height=a[7];
        this.slope=a[8];
        this.volume=a[9];
        this.latitude=a[10];
        this.longitude=a[11];

    }



    @Override
    public String toString() {
        return "Pyramid{" +
                "pharoa='" + pharoa + '\'' +

                ", base1='" + base1 + "m\'" +

                "}\n";
    }
}




