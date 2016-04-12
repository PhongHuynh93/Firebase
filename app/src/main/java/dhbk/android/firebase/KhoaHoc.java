package dhbk.android.firebase;

/**
 * Created by huynhducthanhphong on 4/12/16.
 */
public class KhoaHoc {
    public String TenKH;
    public int HocPhi;

    public KhoaHoc(String tenKH, int hocPhi) {
        TenKH = tenKH;
        HocPhi = hocPhi;
    }

    // them object vào firebase thì bắc buộc phải tạo 1 empty constructor
    public KhoaHoc() {
    }
}
