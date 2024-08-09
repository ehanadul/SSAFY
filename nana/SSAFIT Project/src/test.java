
public class test {

	SsafitApplication 
	(com.ssafy.fit.test)
	main(args: String[]): void

	VideoDao - Interface
	(com.ssafy.fit.model.dao)
	+ selectVideo(): List<Video>
	+ selectVideoByNo(no: int): Video

	VideoDaolmpl
	(com.ssafy.fit.model.dao)
	- list: List<Video>
	- instance: VideoDaolmpl
	+ VideoDaolmpl()
	+ getInstance(): VideoDaolmpl
	+ selectVideo(): List<Video>
	+ selectVideoByNo(no: int): Video

	Video
	(com.ssafy.fit.model)
	- no: int
	- title: String
	- part: String
	- url: String
	+ getNo(): int
	+ setNo(no: int): void
	+ getTitle(): String
	+ setTitle(title: String): void
	+ getPart(): String
	+ setPart(part: String): void
	+ getUrl(): String
	+ setUrl(url: String): void toString(): String
	+ toString() : String

	MainUi
	(com.ssafy.fit.ui)
	+ service(): void
	- exit(): void

	VideoUi 
	(com.ssafy.fit.ui)
	- videoDao: VideoDao
	- instance: VideoUi
	- VideoUi()
	+ getInstance(): VideoUi
	+ service(): void
	- listVideo(): void
	- detailVideo: void

	VideoReviewUi
	(com.ssafy.fit.ui)
	- videoReviewDao: VideoReviewDao
	- instance: VideoReviewUi
	- videoNo: int
	- VideoReviewUi(videoNo: int)
	+ getInstance(videoNo: int): VideoReviewUi
	+ service(): void
	- listReview(): void
	- registReview(): void
	
	
	SsafitUtil 
	(com.ssafy.fit.util)
	sc: Scanner SsafitUtil
	+ SsafitUtil()
	+ input(msg: String): String 
	+ inputInt(msg: String): int
	+ printLine(): void
	+ printLine(ch: char): void
	+ printLine(ch: char, len: int): void 
	+ screenClear(): void

	VideoReviewDao - interface
	(com.ssafy.fit.model.dao)
	+ insertReview(videoReview: VideoReview): int
	+ selectReview(videoNo: int): List<VideoReview>

	VideoReviewDaolmpl
	(com.ssafy.fit.model.dao)
	- reviewNo: int
	- videoReviewDb: Map<Integer, List<VideoReview>>
	- instance: VideoReviewDaolmpl
	+ VideoReviewDaolmpl()
	+ getInstance(): VideoReviewDaolmpl
	+ insertReview(videoReview: VideoReview): int 
	+ selectReview(videoNo: int): List<VideoReview>


	VideoReview com.ssafy.fit.model
	- videoNo: int
	-  reviewNo: int
	- nickName: String
	- content: String
	+ getVideoNo(): int
	+ setVideoNo(videoNo: int): void 
	+getNickName(): String
	+ setNickName(nickName: String): void 
	+ getReviewNo0): int
	+ setReviewNo(reviewNo: int): void
	+ getContent(): String
	+ setContent(content: String): void
	
}
