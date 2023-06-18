package moon.adn.code.model.character.identity.names;

import moon.adn.code.model.character.identity.SexEnum;

/**
 * Interface for {@link NamesGenerator}.
 * @author Cédric DELRUE
 *
 */
public interface NamesGenerator {
	/**
	 * @param sex Male or Female name to generate
	 * @return the generatedName with firstName and Last Name
	 */
	public String generateCompleteName(SexEnum sex);

	/**
	 * @param sex Male or Female name to generate
	 * @return Only generated firstName
	 */
	public String generateFirstName(SexEnum sex);
}
