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

import java.util.ArrayList;
import java.util.List;

import kr.co.shineware.ds.trie.TrieDictionary;
import kr.co.shineware.nlp.komoran.interfaces.FileAccessible;
import kr.co.shineware.nlp.komoran.interfaces.HDFSAccessible;
import org.apache.hadoop.fs.Path;

public class IrregularTrie implements FileAccessible, HDFSAccessible {
	private TrieDictionary<List<IrregularNode>> dic;
	
	public IrregularTrie(){
		this.init();
	}

	public void init(){
		this.dic = null;
		this.dic = new TrieDictionary<>();
	}

	public void put(String irr,IrregularNode irrNode){
		List<IrregularNode> irrNodeList = this.dic.get(irr);
		if(irrNodeList == null){
			irrNodeList = new ArrayList<>();
			irrNodeList.add(irrNode);
		}else{
			boolean hasSameNode = false;
			for (IrregularNode irregularNode : irrNodeList) {
				if(irrNode.equals(irregularNode)){
					hasSameNode = true;
					break;
				}
			}
			if(!hasSameNode){
				irrNodeList.add(irrNode);
			}
		}
		this.dic.put(irr, irrNodeList);
	}
	
	public TrieDictionary<List<IrregularNode>> getTrieDictionary(){
		return dic;
	}

	@Override
	public void save(String filename) {
		this.dic.save(filename);
	}

	@Override
	public void load(String filename) {
		this.dic.load(filename);		
	}

	@Override
	public void save(Path filePath) {
		this.dic.save(filePath);
	}

	@Override
	public void load(Path filePath) {
		this.dic.load(filePath);
	}
}
