/*
 * KOMORAN 2.0 - Korean Morphology Analyzer
 *
 * Copyright 2014 Shineware http://www.shineware.co.kr
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.co.shineware.nlp.komoran.modeler.model;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import kr.co.shineware.nlp.komoran.interfaces.FileAccessible;
import kr.co.shineware.nlp.komoran.interfaces.HDFSAccessible;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Transition implements FileAccessible, HDFSAccessible{
	
	private double[][] scoreMatrix;

	public Transition(){
		;
	}
	
	public Transition(int size) {
		scoreMatrix = new double[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				scoreMatrix[i][j] = Double.NEGATIVE_INFINITY;
			}
		}
	}

	public void put(int prevId, int curId, double transitionScore) {
		scoreMatrix[prevId][curId] = transitionScore;
	}
	public Double get(int prevId, int curId){
		if(scoreMatrix[prevId][curId] == Double.NEGATIVE_INFINITY){
			return null;
		}else{
			return scoreMatrix[prevId][curId];
		}
	}

	@Override
	public void save(String filename) {
		try {
			save(new ObjectOutputStream(new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(filename)))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(Path filePath) {
		try {
			FileSystem fs = FileSystem.get(new Configuration());
			save(new ObjectOutputStream(new BufferedOutputStream(new GZIPOutputStream(fs.create(filePath, true)))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void save(ObjectOutputStream oos) {
		try {
			oos.writeObject(scoreMatrix);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load(String filename) {
		try {
			load(new ObjectInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(filename)))));
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	@Override
	public void load(Path filePath) {
		try {
			FileSystem fs = FileSystem.get(new Configuration());
			load(new ObjectInputStream(new BufferedInputStream(new GZIPInputStream(fs.open(filePath)))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void load(ObjectInputStream ois) {
		try {
			scoreMatrix = (double[][]) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
