package kr.co.shineware.nlp.komoran.interfaces;

import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by samuel281 on 16. 2. 29..
 */
public interface HDFSAccessible {
    /**
     * 현재 사용되고 있는 데이터를 filename에 저장
     * @param filename
     */
    public void save(Path filename);
    /**
     * 저장된 filename으로부터 데이터 로드
     * @param filename
     */
    public void load(Path filename);
}
