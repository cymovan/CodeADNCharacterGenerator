package moon.adn.code.model.character.identity;

public interface NamesGenerator {
	public String generateCompleteName(SexEnum sex);

	public String generateFirstName(SexEnum sex);
}
