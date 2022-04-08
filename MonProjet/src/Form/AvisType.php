<?php

namespace App\Form;

use App\Entity\Avis;
use App\Entity\Livre;
use App\Entity\Utilisateur;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class AvisType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('commentaire')
            ->add('idLivre',EntityType::class,[
                'label'=>"Livre",
                'class'=>Livre::class,
                'choice_label'=>"titre"
            ])
            ->add('idUser',EntityType::class,[
                'label'=>"Utilisateur",
                'class'=>Utilisateur::class,
                'choice_label'=>"username"
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Avis::class,
        ]);
    }
}
