import javax.swing.*;
import java.util.Optional;

public class ComboBoxItem {
    private final String text;
    private final Object content;

    public ComboBoxItem(String text, Object content) {

        this.text = text;
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    @Override
    public String toString() {
        return text;
    }

    public static Optional<Object> getSelectedContent(JComboBox combo) {
        Object selectedItem1 = combo.getSelectedItem();
        if (selectedItem1 instanceof ComboBoxItem) {
            ComboBoxItem selectedItem = (ComboBoxItem) selectedItem1;
            return Optional.ofNullable(selectedItem).map(ComboBoxItem::getContent);
        }
        return Optional.empty();
    }
}
