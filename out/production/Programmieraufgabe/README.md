# 186.815 Algorithmen und Datenstrukturen 2 VU 3.0
## Aufgabenstellung

Sie haben vor Kurzem bei einem neu gegründeten Internetprovider zu arbeiten angefangen, der mit Ihrer Hilfe seine Infrastruktur aufbauen will. Der Provider hat es sich zur Aufgabe gemacht Datenzentren für sehr sensible Daten zu bauen und diese in verschiedenen Regionen der Welt zu errichten. Ihr Auftraggeber erhofft sich durch die geographische Verteilung und die unterschiedlichen Rechtslagen in den Ländern die Daten seiner Kunden besser schützen zu können.

Eine vorläufige Analyse hat ergeben, dass eine Verteilung auf `k` verschiedene Regionen eine ausreichende Sicherheit gewährleistet ohne zu hohe Kosten zu verursachen. Um die Kommunikation zwischen den Datenzentren besser kontrollieren zu können, hat sich ihr Auftraggeber dafür entschieden Standleitungen zwischen den Datenzentren zu errichten bzw. zu mieten. Dies ist jedoch mit erheblichen Kosten verbunden.

Nach kurzem Überlegen wird Ihnen klar,dass eine baumartige Vernetzung der Zentren die geringste Anzahl an Leitungen benötigt. Weiters wissen Sie, dass Ihr Auftraggeber die Kosten für den Bau eines Datenzentrums an jedem Standort als ident einschätzt. Aufgrund dieser Annahmen kann nur ein Baum die geringsten Kosten verursachen, da sonst immer eine Verbindung eingespart werden könnte.

Als guter Algorithmiker erkennen Sie sofort, dass es sich um eine Generalisierung des `Minimum Spanning Tree Problems (MST)` handelt, welches nicht alle Knoten eines Graphen berücksichtigt, sondern nur eine zu treffende Auswahl von `k` Knoten. Dieses Problem ist als `k-Minimum Spanning Tree Problem (k-MST)` bekannt.

Sie können Ihr Problem folgendermaßen definieren:

Gegeben sei ein gewichteter Graph `G = (V,E)` mit einer Kostenfunktion `c : E -> R` die jeder Kante Kosten zuordnet und ein zusätzlicher Parameter `k`. Es soll nun ein zusammenhängender Teilbaum minimalen Gewichts (Kantensumme) mit genau `k Knoten aus `V` gefunden werden.
Sie wissen aus _Algorithmen und Datenstrukturen 1_, dass das MST Problem in polynomieller Zeit lösbar ist. Das `k-MST` Problem hingegen ist __NP__-schwer. Da Sie vor Kurzem in _Algorithmen und Datenstrukturen 2_ das _Branch-and-Bound Verfahren_ kennengelernt haben, entschließen Sie sich, das Problem auf diese Weise exakt zu lösen.


Konkret sieht Ihre Aufgabenstellung wie folgt aus:

1. Überlegen Sie, wie Sie das Branching ausführen, d.h., wie Sie ein (Unter-)Problem in weitere Unterprobleme zerteilen und mithilfe welcher Datenstrukturen Sie offene (Unter-)Probleme speichern.
2. Entwickeln Sie eine Dualheuristik, die für jedes (Unter-)Problem eine lokale untere Schranke liefert.
3. Entwickeln Sie darauf aufbauend einen heuristischen Algorithmus, um für ein (Unter-)Problem möglicherweise eine gültige Lösung zu erhalten, deren Wert eine globale obere Schranke darstellt.
4. Für die grundsätzliche Funktionsweise des Branch-and-Bound ist es egal, welches offene Unterproblem aus der Problemliste ausgewählt und als nächstes abgearbeitet wird. In der Praxis spielt diese Auswahlstrategie jedoch in Bezug auf die Laufzeit eine große Rolle. Wir schlagen hier vor, als erstes eine `Depth-First-Strategie` zu implementieren, bei der nach einem Branching immer eines der neu erzeugten Unterprobleme als unmittelbar nächstes abgearbeitet wird. In dieser Weise kann das Branch-and-Bound direkt als rekursiver Algorithmus ohne zusätzliche Datenstruktur zur expliziten Speicherung der Problemliste implementiert werden.
5. Implementieren Sie nun das vollständige Branch-and-Bound, das auf den oben genannten Punkten aufbaut.