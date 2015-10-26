/**
 * Copyright (c) 2013, 2015 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath3.resource.xpath3.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;

public class Xpath3CompletionProcessor implements IContentAssistProcessor {
	
	private org.emftext.language.xpath3.resource.xpath3.IXpath3ResourceProvider resourceProvider;
	
	public Xpath3CompletionProcessor(org.emftext.language.xpath3.resource.xpath3.IXpath3ResourceProvider resourceProvider) {
		super();
		this.resourceProvider = resourceProvider;
	}
	
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		org.emftext.language.xpath3.resource.xpath3.IXpath3TextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		return computeCompletionProposals(textResource, content, offset);
	}
	
	public ICompletionProposal[] computeCompletionProposals(org.emftext.language.xpath3.resource.xpath3.IXpath3TextResource textResource, String text, int offset) {
		org.emftext.language.xpath3.resource.xpath3.ui.Xpath3CodeCompletionHelper helper = new org.emftext.language.xpath3.resource.xpath3.ui.Xpath3CodeCompletionHelper();
		org.emftext.language.xpath3.resource.xpath3.ui.Xpath3CompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, text, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		org.emftext.language.xpath3.resource.xpath3.ui.Xpath3ProposalPostProcessor proposalPostProcessor = new org.emftext.language.xpath3.resource.xpath3.ui.Xpath3ProposalPostProcessor();
		List<org.emftext.language.xpath3.resource.xpath3.ui.Xpath3CompletionProposal> computedProposalList = Arrays.asList(computedProposals);
		List<org.emftext.language.xpath3.resource.xpath3.ui.Xpath3CompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = Collections.emptyList();
		}
		List<org.emftext.language.xpath3.resource.xpath3.ui.Xpath3CompletionProposal> finalProposalList = new ArrayList<org.emftext.language.xpath3.resource.xpath3.ui.Xpath3CompletionProposal>();
		for (org.emftext.language.xpath3.resource.xpath3.ui.Xpath3CompletionProposal proposal : extendedProposalList) {
			if (proposal.isMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		ICompletionProposal[] result = new ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (org.emftext.language.xpath3.resource.xpath3.ui.Xpath3CompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = (proposal.getDisplayString()==null)?proposalString:proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			Image image = proposal.getImage();
			IContextInformation info;
			info = new ContextInformation(image, displayString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			result[i++] = new CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		IPreferenceStore preferenceStore = org.emftext.language.xpath3.resource.xpath3.ui.Xpath3UIPlugin.getDefault().getPreferenceStore();
		boolean enabled = preferenceStore.getBoolean(org.emftext.language.xpath3.resource.xpath3.ui.Xpath3PreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED);
		String triggerString = preferenceStore.getString(org.emftext.language.xpath3.resource.xpath3.ui.Xpath3PreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS);
		if(enabled && triggerString != null && triggerString.length() > 0){
			char[] triggers = new char[triggerString.length()];
			for (int i = 0; i < triggerString.length(); i++) {
				triggers[i] = triggerString.charAt(i);
			}
			return triggers;
		}
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
