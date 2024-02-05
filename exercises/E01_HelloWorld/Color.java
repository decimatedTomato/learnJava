/**
 * This is an example java class structure
 */

package exercises.E01_HelloWorld;       // File location relative to root

// Imports go here

public class Color {                    // Name of class (all contents of class relate to this type of object)
    
    public static final Color BLACK = new Color(0, 0, 0); // Constants that are relevant to a specific class are specified like this
    
    private float _red;                 // attributes of this type of object (almost always private)
    private float _green;
    private float _blue;

    /**
     * Public useful method
     * Performs an action the user might want from this type
     */
    public float getNormRed() {
        return _red;
    }
    public float getNormGreen() {
        return _green;
    }
    public float getNormBlue() {
        return _blue;
    }
    public String toHexCode() {
        return String.format("#%i%i%i", (int)(_red * 255), (int)(_green * 255), (int)(_blue * 255));
    }
    public String toRGBCode() {
        return String.format("%i, %i, %i", (int)(_red * 255), (int)(_green * 255), (int)(_blue * 255));
    }

    /**
     * Public static method
     * Can be used without any specific Color object
     */
    public static Color fromHexcode(String hexCode) throws IllegalArgumentException, NumberFormatException {
        if (hexCode == null) throw new NumberFormatException("Cannot parse null string");
        if (hexCode.length() != 7 || hexCode.charAt(0) != '#') throw new IllegalArgumentException("Not in proper hexcode format");
        float r = Integer.parseInt("" + hexCode.charAt(1) + hexCode.charAt(2), 16) / 255;
        float g = Integer.parseInt("" + hexCode.charAt(3) + hexCode.charAt(4), 16) / 255;
        float b = Integer.parseInt("" + hexCode.charAt(5) + hexCode.charAt(6), 16) / 255;
        return new Color(r, g, b);            
    }

    /**
     * Constructor of objects in class
     * After the constructor call a Color should be in a valid state
     */
    public Color(float r, float g, float b) {
        _red = r;
        _green = g;
        _blue = b;
    }

    /* Decided against this one
    private class HSBColor {
        float hue;
        float saturation;
        float brightness;
        
        HSBColor(Color col) {
            int r = getIntRed();
            int g = getIntGreen();
            int b = getIntBlue();

            int cmax = (r > g) ? r : g;
            if (b > cmax) cmax = b;
            int cmin = (r < g) ? r : g;
            if (b < cmin) cmin = b;

            brightness = ((float) cmax) / 255.0f;
            if (cmax != 0)
                saturation = ((float) (cmax - cmin)) / ((float) cmax);
            else
                saturation = 0;
            if (saturation == 0)
                hue = 0;
            else {
                float redc = ((float) (cmax - r)) / ((float) (cmax - cmin));
                float greenc = ((float) (cmax - g)) / ((float) (cmax - cmin));
                float bluec = ((float) (cmax - b)) / ((float) (cmax - cmin));
                if (r == cmax)
                    hue = bluec - greenc;
                else if (g == cmax)
                    hue = 2.0f + redc - bluec;
                else
                    hue = 4.0f + greenc - redc;
                hue = hue / 6.0f;
                if (hue < 0) 
                    hue = hue + 1.0f;
            }
        }
    } */

    
    /**
     * An inner class, may be used (for convenience mostly) inside of the scope of methods in this class
     */
    private class SemitransparentColor {
        Color _col;
        float _alpha;
        SemitransparentColor(Color col, float alpha) {
            _col = col;
            _alpha = alpha;
        }

        /*
         * Big ups to https://www.youtube.com/watch?v=bfvmPa9eWew&t=1500s
         */
        static SemitransparentColor mix(SemitransparentColor srcCol, SemitransparentColor dstCol) {
            float compAlpha = srcCol._alpha + (1 - srcCol._alpha) * dstCol._alpha;
            float r = (srcCol._col.getNormRed() + (1 - srcCol._alpha) * dstCol._col.getNormRed() * dstCol._alpha) / compAlpha;
            float g = (srcCol._col.getNormGreen() + (1 - srcCol._alpha) * dstCol._col.getNormGreen() * dstCol._alpha) / compAlpha;
            float b = (srcCol._col.getNormBlue() + (1 - srcCol._alpha) * dstCol._col.getNormBlue() * dstCol._alpha) / compAlpha;
            Color col = new Color(r, g, b);
            return col.new SemitransparentColor(col, compAlpha);
        }
    }
    public Color mixColors(float currentAlpha, Color otherCol, float otherAlpha) {
        return SemitransparentColor.mix(new SemitransparentColor(this, currentAlpha), new SemitransparentColor(otherCol, otherAlpha))._col;
    }

    /**
     * Private helper methods
     * This may be used by other methods in this class, but not outside of it
     */
    private void invert() {
        _red = 1f - _red;
        _green = 1f - _green;
        _blue = 1f - _blue;
    }
    // private int getIntRed() {
    //     return (int)(_red * 255);
    // }
    // private int getIntGreen() {
    //     return (int)(_green * 255);
    // }
    // private int getIntBlue() {
    //     return (int)(_blue * 255);
    // }

    /**
     * The main method is the entry point of a java program
     * (there may be multiple entry points across a project, it may be that this main only exists to test this class while it is developed)
     * The main method always has this exact structure, the args variable (doesn't need to use that name) contains any command-line arguments
     * a user passed when running the program
     * Oftentime the main will not be inside ofa useful class like this but rather in a dedicated class that does nothing other than initialize
     * other objects and call their methods, sometimes the main class may handle configurations using command-line arguments
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Color a = new Color(0.25f, 0.333f, 1f);     // This is how constructors for objects are called
        a.invert();
        System.out.println(a.toHexCode());
    }
}