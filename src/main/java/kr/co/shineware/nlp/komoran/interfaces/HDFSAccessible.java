package kr.co.shineware.nlp.komoran.interfaces;

import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by samuel281 on 16. 2. 29..
 */
public interface HDFSAccessible {
    /**
     * 현재 사용되고 있는 데이터를 filename에 저장
     * @param filePath
     */
    public void save(Path filePath);
    /**
     * 저장된 filename으로부터 데이터 로드
     * @param filePath
     */
    public void load(Path filePath);
}
