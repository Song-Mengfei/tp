package seedu.flashlingo.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.flashlingo.logic.Messages;
import seedu.flashlingo.model.Model;
import seedu.flashlingo.model.flashcard.WordOverduePredicate;

/**
 * Finds and lists all flashcards in flashlingo who is overdue.
 */
public class ReviewCommand extends Command {

    public static final String COMMAND_WORD = "review";

    public static final String MESSAGE_SUCCESS = "Listed all flashcards you need to review";

    /**
     * The predicate used to filter the flashcard which is overdue.
     */
    private final WordOverduePredicate predicate;

    public ReviewCommand() {
        this.predicate = new WordOverduePredicate();
    }
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredFlashCardList(predicate);
        return new CommandResult(MESSAGE_SUCCESS + "\n"
                + String.format(Messages.MESSAGE_FLASHCARDS_LISTED_OVERVIEW + "\n"
                                + model.getFilteredFlashCardList(),
                        model.getFilteredFlashCardList().size()));
    }
}
