package com.jmavarez.materialcalendar;

import com.jmavarez.materialcalendar.util.CalendarDay;
import static com.jmavarez.materialcalendar.util.CanvasHelper.dpToPx;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.components.StackLayout;
import ohos.agp.components.Text;
import ohos.agp.components.element.Element;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.text.Font;
import ohos.agp.utils.Color;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.utils.TextAlignment;
import ohos.agp.window.service.DisplayManager;
import ohos.app.Context;

/**
 * DayView
 */
public class DayView extends StackLayout {
    private int defaultHeight = 30;
    private int defaultIndicatorMarginBottom = 2;
    private int defaultIndicatorSize = 4;
    private static final int DEFAULT_TEXT_SIZE = 12;

    private Element indicatorDrawable;
    private Element selectionDrawable;

    private Integer indicatorMarginBottom;
    private Integer indicatorSize;
    private Integer measuredHeight;


    private Context context;
    private Component indicator;
    private CalendarDay day;
    private boolean indicatorVisible;
    private boolean selected;

    public Component getIndicator() {
        return indicator;
    }

    public void setIndicator(Component indicator) {
        this.indicator = indicator;
    }

    private DisplayManager metrics;
    private Text tvDay;

    public Text getTvDay() {
        return tvDay;
    }

    public void setTvDay(Text tvDay) {
        this.tvDay = tvDay;
    }

    public Element get_indicatorDrawable() {
        return indicatorDrawable;
    }

    public void set_indicatorDrawable(Element indicatorDrawable) {
        this.indicatorDrawable = indicatorDrawable;
    }

    public Element get_selectionDrawable() {
        return selectionDrawable;
    }

    public void set_selectionDrawable(Element selectionDrawable) {
        this.selectionDrawable = selectionDrawable;
    }

    public Integer get_indicatorMarginBottom() {
        return indicatorMarginBottom;
    }

    public void set_indicatorMarginBottom(Integer indicatorMarginBottom) {
        this.indicatorMarginBottom = indicatorMarginBottom;
    }

    public Integer get_indicatorSize() {
        return indicatorSize;
    }

    public void set_indicatorSize(Integer indicatorSize) { this.indicatorSize = indicatorSize;
    }

    public Integer get_measuredHeight() {
        return measuredHeight;
    }

    public void set_measuredHeight(Integer measuredHeight) {
        this.measuredHeight = measuredHeight;
    }

    public void setDay (CalendarDay day) {
        this.day = day;
    }

    public boolean isIndicatorVisible() {
        return indicatorVisible;
    }

    public void setIndicatorVisible (boolean indicatorVisible) {
        this.indicatorVisible = indicatorVisible;
    }

    public DisplayManager getMetrics() {
        return metrics;
    }

    public void setMetrics (DisplayManager metrics) {
        this.metrics = metrics;
    }

    /**
     *
     * @param context
     */
    public DayView(Context context) {
        super(context);

    }

    /**
     *
     * @param context
     * @param day
     */
    public DayView(Context context, CalendarDay day) {
        super(context);

        this.day = day;
        this.context = context;
        init();
    }

    /**
     *
     * @param context
     * @param attrs
     */
    public DayView(Context context, AttrSet attrs) {
        super(context, attrs);
    }

    /**
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public DayView(Context context, AttrSet attrs, int defStyleAttr) {
          super(context, attrs, String.valueOf(defStyleAttr));
    }

    private Element generateCircleCanvas(Color color) {

        ShapeElement element = new ShapeElement();
        element.setShape(ShapeElement.OVAL);
        element.setRgbColor(new RgbColor(color.getValue()));
        return element;
    }

    private void init() {

        this.selected = false;
        this.indicatorVisible = false;
        this.tvDay = new Text(getContext());
        this.tvDay.setText(String.format("%d", this.day.getDay()));
        this.tvDay.setTextSize(dpToPx(getContext(), DEFAULT_TEXT_SIZE));
        this.tvDay.setTextColor(Color.WHITE);
        this.tvDay.setTextAlignment(TextAlignment.CENTER);
        StackLayout.LayoutConfig layoutConfig;
        layoutConfig = new StackLayout.LayoutConfig(getDefaultMeasuredHeight(), getDefaultMeasuredHeight());
        layoutConfig.alignment = LayoutAlignment.HORIZONTAL_CENTER;
        this.tvDay.setLayoutConfig(layoutConfig);

        this.indicator = new Component(getContext());
        StackLayout.LayoutConfig indicatorconfig = new StackLayout.LayoutConfig(getDefaultIndicatorSize(), getDefaultIndicatorSize());
        indicatorconfig.alignment = LayoutAlignment.BOTTOM + LayoutAlignment.HORIZONTAL_CENTER;
        indicatorconfig.setMargins(0, 0, 0, getDefaultIndicatorMarginBottom());
        this.indicator.setLayoutConfig(indicatorconfig);

        this.addComponent(this.tvDay);
        this.addComponent(this.indicator);

    }

    public CalendarDay getDay() {
        return this.day;
    }

    public String getText() {
        return this.tvDay.getText();
    }

    public boolean isSelected() {
        return this.selected;
    }

    /**
     * setSelected
     * @param selected
     */
    @SuppressWarnings("deprecation")
    public void setSelected(boolean selected) {
        if (this.selected != selected) {
            this.selected = selected;

            if (this.selected) {
                Element element = getSelectionDrawable();
                this.tvDay.setBackground(element);
                this.tvDay.setTextColor(Color.MAGENTA);
                this.indicator.setVisibility(Component.HIDE);
                Font font = Font.DEFAULT_BOLD;
                this.tvDay.setFont(font);
                return;
            }

            this.tvDay.setBackground(null);
            this.tvDay.setTextColor(Color.WHITE);
            Font font = Font.DEFAULT;
            this.tvDay.setFont(font);
            refreshIndicatorVisibility();
        }
    }

    /**
     * setIndicatorVisibility
     * @param visible
     */
    @SuppressWarnings("deprecation")
    public void setIndicatorVisibility(boolean visible) {
        if (this.indicatorVisible != visible) {
            this.indicatorVisible = visible;

            if (this.indicatorVisible && this.indicator.getBackgroundElement() == null) {
                Element element = getIndicatorDrawable();
                this.indicator.setBackground(element);
            }

            refreshIndicatorVisibility();
        }
    }

    private void refreshIndicatorVisibility() {
        Component indicator1 = this.indicator;

        if (!this.selected && this.indicatorVisible) {
            indicator1.setVisibility(Component.VISIBLE);
            return;
        }

        indicator1.setVisibility(Component.HIDE);
    }


    private int getDefaultMeasuredHeight() {
        if (measuredHeight == null) {
            measuredHeight =  dpToPx(context, defaultHeight);
        }
        return measuredHeight;
    }

    private int getDefaultIndicatorSize() {
        if (indicatorSize == null) {
            indicatorSize =  dpToPx(context, defaultIndicatorSize);
        }
        return indicatorSize;
    }

    private int getDefaultIndicatorMarginBottom() {
        if (indicatorMarginBottom == null) {
            indicatorMarginBottom = dpToPx(context, defaultIndicatorMarginBottom);
        }
        return indicatorMarginBottom;
    }

    private Element getSelectionDrawable() {
        if (selectionDrawable == null) {
            selectionDrawable = generateCircleCanvas(Color.WHITE);
        }
        return selectionDrawable;
    }

    private Element getIndicatorDrawable() {
        if (indicatorDrawable == null) {
            indicatorDrawable = generateCircleCanvas(Color.MAGENTA);
        }
        return indicatorDrawable;
    }
}

