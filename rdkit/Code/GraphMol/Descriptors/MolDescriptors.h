//
//  Copyright (C) 2004-2021 Greg Landrum and other RDKit contributors
//
//   @@ All Rights Reserved @@
//  This file is part of the RDKit.
//  The contents are covered by the terms of the BSD license
//  which is included in the file license.txt, found at the root
//  of the RDKit source tree.
//

#include <RDGeneral/export.h>
#ifndef RD_MOLDESCRIPTORS_H
#define RD_MOLDESCRIPTORS_H

#include <GraphMol/Descriptors/Crippen.h>
#include <GraphMol/Descriptors/MolSurf.h>
#include <GraphMol/Descriptors/Lipinski.h>
#include <GraphMol/Descriptors/ConnectivityDescriptors.h>
#include <GraphMol/Descriptors/MQN.h>
#include <GraphMol/Descriptors/AUTOCORR2D.h>

namespace RDKit {
class ROMol;
namespace Descriptors {
/*!
  Calculates a molecule's average molecular weight

  \param mol        the molecule of interest
  \param onlyHeavy  (optional) if this is true (the default is false),
      only heavy atoms will be included in the MW calculation

  \return the AMW
*/
RDKIT_DESCRIPTORS_EXPORT extern const std::string amwVersion;
RDKIT_DESCRIPTORS_EXPORT double calcAMW(const ROMol &mol,
                                        bool onlyHeavy = false);
/*!
  Calculates a molecule's number of heavy (non-hydrogen) atoms

  \param mol        the molecule of interest

  \return the number of heavy atoms
*/
RDKIT_DESCRIPTORS_EXPORT extern const std::string NumHeavyAtomsVersion;
RDKIT_DESCRIPTORS_EXPORT unsigned int calcNumHeavyAtoms(const ROMol &mol);
/*!
  Calculates a molecule's number of atoms

  \param mol        the molecule of interest

  \return the number of atoms
*/
RDKIT_DESCRIPTORS_EXPORT extern const std::string NumAtomsVersion;
RDKIT_DESCRIPTORS_EXPORT unsigned int calcNumAtoms(const ROMol &mol);
/*!
  Calculates a molecule's exact molecular weight

  \param mol        the molecule of interest
  \param onlyHeavy  (optional) if this is true (the default is false),
      only heavy atoms will be included in the MW calculation

  \return the exact MW
*/
RDKIT_DESCRIPTORS_EXPORT extern const std::string exactmwVersion;
RDKIT_DESCRIPTORS_EXPORT double calcExactMW(const ROMol &mol,
                                            bool onlyHeavy = false);
/*!
  Calculates a molecule's formula

  \param mol        the molecule of interest
  \param separateIsotopes  if true, isotopes will show up separately in the
     formula. So C[13CH2]O will give the formula: C[13C]H6O
  \param abbreviateHIsotopes  if true, 2H and 3H will be represented as
     D and T instead of [2H] and [3H]. This only applies if \c separateIsotopes
     is true

  \return the formula as a string
*/
RDKIT_DESCRIPTORS_EXPORT std::string calcMolFormula(
    const ROMol &mol, bool separateIsotopes = false,
    bool abbreviateHIsotopes = true);

}  // end of namespace Descriptors
}  // end of namespace RDKit

#endif
