package la321.katy.com.fatcat;

import android.os.Parcel;
import android.os.Parcelable;

public class ChildList1 implements Parcelable {

    protected ChildList1(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ChildList1> CREATOR = new Creator<ChildList1>() {
        @Override
        public ChildList1 createFromParcel(Parcel in) {
            return new ChildList1(in);
        }

        @Override
        public ChildList1[] newArray(int size) {
            return new ChildList1[size];
        }
    };
}
