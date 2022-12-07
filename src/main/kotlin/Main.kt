data class MemoryData(
    val id: Int,
    val imageUrlList: List<String>,
    val content: String,
    val location: LocationData,
    val address: String,
    val createdDate: String,
) {
    data class LocationData(
        val latitude: Double,
        val longitude: Double,
    )
}

data class Memory(
    val id: Int,
    val imageUrlList: List<String>,
    val content: String,
    val location: Location,
    val address: String,
    val createdDate: String,
) {
    data class Location(
        val latitude: Double,
        val longitude: Double,
    )
}

fun MemoryData.toDomain() = Memory(
    id = id,
    imageUrlList = imageUrlList,
    content = content,
    location = Memory.Location(
        latitude = location.latitude,
        longitude = location.longitude
    ),
    address = address,
    createdDate = createdDate
)