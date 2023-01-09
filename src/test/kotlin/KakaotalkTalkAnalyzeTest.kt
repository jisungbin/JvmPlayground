import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class KakaotalkTalkAnalyzeTest {
    @Test
    @DisplayName("cvs parse")
    fun splitcvs() {
        val s = "John Doe, 13, \"Subject 1, Subject 2, Subject 3\""
        val list: List<String> = s.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)".toRegex())
        println(list)
    }

    @Test
    @DisplayName("cvs parse multi line")
    fun splitcvs2() {
        val s = """
            2022-11-07 16:00:19,"aaaaaaaaaaa","LazyVerticalGrid를 LazyColumn 안에 넣어서 parent인 LazyColumn단만 스크롤되게 하고싶은데 어떻게 해야할까요 지금 문제는 뷰를 그리는 과정에서 LazyVerticalGrid의 크기를 구하지 못해서 에러가 나는 상황입니다..ㅠㅠ"
            2022-11-07 16:01:27,"bbbb","혹시 super 전에 작성하셨을까요?"
            2022-11-07 16:06:33,"bbbb","1. userScrollEnabled 인자로 스크롤 여부를 조정할 수 있습니다
            2. Modifier.onPlaced 로 컴포저블이 배치됐을 때 크기를 구할 수 있습니다"
            2022-11-07 16:12:21,"cccc","super.onCreate(savedInstanceState) 네 이 메서드 전에 작성했습니다"
            2022-11-08 17:23:56,"dddd","사진"
        """.trimIndent()
        val list: List<String> = s.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)|\n".toRegex()) // 90000글자 정도에서 에러남 정규식 사용불가
        println(list.size)
        list.forEach { println(it.replace("\n", "\\n")) }
    }
}