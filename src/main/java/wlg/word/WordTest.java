package wlg.word;

import java.util.List;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

public class WordTest {
	
	public static void main(String[] args) {
		String str = "荣耀 NOTE 8 4GB+64GB 全网通手机 冰河银" ;
		System.out.println(ToAnalysis.parse(str));
		System.out.println(NlpAnalysis.parse(str));
		
		List<Word> w = WordSegmenter.seg(str);
		System.out.println(w);
		
		KeyWordComputer kwc = new KeyWordComputer(5);
		List<Keyword> words = kwc.computeArticleTfidf(str);
		System.out.println(words);
	}
}
