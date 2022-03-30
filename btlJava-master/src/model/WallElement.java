//File phần tử tường
package model;

import model.UnitGameObject;
import model.UrlConstants;
import model.ImageUtils;

public class WallElement extends UnitGameObject {
    public WallElement(int x, int y, int width, int height) {
        super(ImageUtils.generateImageFromUrl(UrlConstants.WALL_URL), x, y, width, height);
    }
}
