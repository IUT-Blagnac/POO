#-----------------------------------------------------
MAIN=main
ICONSDIR=images/icons
IMAGESDIR=images
STYLE=/Users/bruel/dev/POO/stylesheets/golo-jmb.css
ASCIIDOC=asciidoc -a icons -a iconsdir=$(ICONSDIR) -a imagesdir=$(IMAGESDIR) -a stylesheet=$(STYLE) -a data-uri
#ASCIIDOC=asciidoc -a icons -a iconsdir=$(ICONSDIR) -a data-uri
ASCIIDOCTOR=asciidoctor -a icons -a iconsdir=$(ICONSDIR) -a data-uri
EXT=asc
#-----------------------------------------------------

all: TP1.html TP4.html TP4.slides.html TP4.corrige.html
        
%.html: %.$(EXT)
	@echo '==> Compiling asciidoc files to generate HTML'
	$(ASCIIDOCTOR) -b html5 -a numbered $< 
%.corrige.html: %.$(EXT)
	@echo '==> Compiling asciidoc files to generate Corrections'
	$(ASCIIDOCTOR) -b html5 -a numbered -a prof -o $@ $< 
%.slides.html: %.$(EXT)
	@echo '==> Compiling asciidoc files to generate Deckjs'
	$(ASCIIDOC) -a slides -b deckjs -a deckjs_transition=horizontal-slide -a deckjs_theme=web-2.0 -o $@ $< 
	
clean: 
	@echo '==> Cleaning compilation files'
	@# fichiers de compilation latex
	@rm -f *.log *.aux *.dvi *.toc *.lot *.lof *.ilg
	@# fichiers de bibtex
	@rm -f *.blg
