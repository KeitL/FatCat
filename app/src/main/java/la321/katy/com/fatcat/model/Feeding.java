//package la321.katy.com.fatcat.model;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//public class Feeding implements Parcelable {
//    private String feedingId;
//    private String feedingTime;
//    private long feedingPortion;
//    private String petOwner;
//
//    public Feeding(String feedingId, String feedingTime, long feedingPortion, String petOwner) {
//        this.feedingId = feedingId;
//        this.feedingTime = feedingTime;
//        this.feedingPortion = feedingPortion;
//        this.petOwner = petOwner;
//    }
//
//    protected Feeding(Parcel in) {
//        feedingId = in.readString();
//        feedingTime = in.readString();
//        feedingPortion = in.readInt();
//        petOwner = in.readString();
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(feedingId);
//        dest.writeString(feedingTime);
//        dest.writeLong(feedingPortion);
//        dest.writeString(petOwner);
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    public static final Creator<Feeding> CREATOR = new Creator<Feeding>() {
//        @Override
//        public Feeding createFromParcel(Parcel in) {
//            return new Feeding(in);
//        }
//
//        @Override
//        public Feeding[] newArray(int size) {
//            return new Feeding[size];
//        }
//    };
//
//    public String getFeedingId() {
//        return feedingId;
//    }
//
//    public void setFeedingId(String feedingId) {
//        this.feedingId = feedingId;
//    }
//
//    public String getFeedingTime() {
//        return feedingTime;
//    }
//
//    public void setFeedingTime(String feedingTime) {
//        this.feedingTime = feedingTime;
//    }
//
//    public long getFeedingPortion() {
//        return feedingPortion;
//    }
//
//    public void setFeedingPortion(int feedingPortion) {
//        this.feedingPortion = feedingPortion;
//    }
//
//    public String getPetOwner() {
//        return petOwner;
//    }
//
//    public void setPetOwner(String petOwner) {
//        this.petOwner = petOwner;
//    }
//}
