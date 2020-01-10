package analysis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FileDocumentTest {
	
	private FileDocument notAnalyzed;
	private FileDocument analyzed;

	@Before
	public void setUp() throws DocumentAnalysisException {
	    File testFile = new File("test/data/test1.txt");
		notAnalyzed = new FileDocument(testFile);
		
		analyzed = new FileDocument(testFile);
		analyzed.analyze(0);
	}
	
	@Test
	public void testNotAnalized() throws DocumentAnalysisException {
		assertFalse(notAnalyzed.isAnalyzed());
		assertEquals(new File("test/data/test1.txt"), notAnalyzed.getFile());
		assertEquals("test1.txt", notAnalyzed.getName());
		assertEquals(0, notAnalyzed.getChars());
		assertEquals(0, notAnalyzed.getWords());
		assertEquals(0, notAnalyzed.getLines());
		assertTrue(notAnalyzed.getWordCount().isEmpty());
		
		assertEquals("name=test1.txt, path=test\\data\\test1.txt, chars=0, words=0, lines=0", notAnalyzed.toString());
	}
	
	@Test
	public void testAnalized() {
		assertTrue(analyzed.isAnalyzed());
		assertEquals(new File("test/data/test1.txt"), analyzed.getFile());
		assertEquals("test1.txt", analyzed.getName());
		assertEquals(33, analyzed.getChars());
		assertEquals(6, analyzed.getWords());
		assertEquals(3, analyzed.getLines());
		
		List<WordCount> wordCount = analyzed.getWordCount();
		assertEquals(3, wordCount.size());
		
		assertEquals("linea", wordCount.get(0).getWord());
		assertEquals(3, wordCount.get(0).getCount().intValue());
		
		assertEquals("otra", wordCount.get(1).getWord());
		assertEquals(2, wordCount.get(1).getCount().intValue());
		
		assertEquals("primera", wordCount.get(2).getWord());
		assertEquals(1, wordCount.get(2).getCount().intValue());
		
		
		assertEquals("name=test1.txt, path=test\\data\\test1.txt, chars=33, words=6, lines=3", analyzed.toString());
	}
}
