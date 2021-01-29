package shop.ui;

import java.util.Objects;

class Pair<F, S> {
	final F prompt;
	final S ui;
	
	public Pair(F prompt, S ui) {
		this.prompt = prompt;
		this.ui=ui;
	}
	
	
	public F getPrompt() {
		return prompt;
	}
	public S getUI() {
		return ui;
	}
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.prompt, prompt) && Objects.equals(p.ui, ui);
    }


    @Override
    public int hashCode() {
        return (prompt == null ? 0 : prompt.hashCode()) ^ (ui == null ? 0 : ui.hashCode());
    }
}
