package archipelagoon.data;

import com.google.gson.annotations.SerializedName;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SlotData {
  public static final Set<String> EXPECTED_MOD_VERSIONS = new HashSet<>(List.of("0.0.2"));

  private SlotData() {
  }

    @SerializedName("enable_addition_randomizer")
    public int enableAdditionRandomizer = 4;

    @SerializedName("random_starting_addition")
    public int randomStartingAddition = 0;

    @SerializedName("lod_completion_condition")
    public int completionCondition = 3;

    //  @SerializedName("death_link")
    //  public int deathLink = 0;

    @SerializedName("mod_version")
    public String modVersion = "0.0.0";
}