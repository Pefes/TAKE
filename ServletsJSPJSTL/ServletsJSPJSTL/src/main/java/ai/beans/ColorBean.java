package ai.beans;

public class ColorBean {
 private String foregroundColor;
 private String backgroundColor;
 private String showBorder;

 public ColorBean() {
 }

    /**
     * @return the foregroundColor
     */
    public String getForegroundColor() {
        return foregroundColor;
    }

    /**
     * @param foregroundColor the foregroundColor to set
     */
    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    /**
     * @return the backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the showBorder
     */
    public String getShowBorder() {
        return showBorder;
    }

    /**
     * @param showBorder the showBorder to set
     */
    public void setShowBorder(String showBorder) {
        this.showBorder = showBorder;
    }
}